package utils;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by vnaksimenko on 25.11.16.
 */
public class JiraHelper {
    private final static String AUTH_HEADER = "Z3JpbnZhbGQyMDE2QGdtYWlsLmNvbTpxMXExdzF3MQ==";
    private final static String JIRA_BASE_URL = "https://auto2020.atlassian.net/";
    private final static String JIRA_URL = JIRA_BASE_URL + "rest/api/2";
    private final static String PROJECT_KEY = "MOOV";

    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
    private final static OkHttpClient client = new OkHttpClient();

    public static String publishJira(String title, String description) throws JSONException, IOException {
        JSONObject data = new JSONObject();
        JSONObject fields = new JSONObject();
        JSONObject project = new JSONObject();
        JSONObject issueType = new JSONObject();

        project.put("key", PROJECT_KEY);
        issueType.put("name", "Bug");

        fields.put("project", project);
        fields.put("summary", title);
        fields.put("description", description);
        fields.put("issuetype", issueType);

        data.put("fields", fields);
        StringWriter out = new StringWriter();
        data.write(out);

        Request request = new Request.Builder()
                .url(JIRA_URL + "/issue")
                .header("Authorization", "Basic " + AUTH_HEADER)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, out.toString()))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        JSONObject resp = new JSONObject(response.body().string());
        return JIRA_BASE_URL + "browse/" + resp.getString("key");      // URL to created Jira ticket
    }
}

