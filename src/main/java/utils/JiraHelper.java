package utils;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringWriter;

import static utils.CommonFunctions.attachIssuesLink;


public class JiraHelper {
    //TODO: Change OAuth access tokens, url, project key
    private final static String AUTH_HEADER = "YWRtaW46YXV0b21hdGlvbjIwMjA=";
    private final static String JIRA_BASE_URL = "https://automation2020.atlassian.net/";
    private final static String JIRA_URL = JIRA_BASE_URL + "rest/api/2";
    private final static String PROJECT_KEY = "AUT";

    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
    private final static OkHttpClient client = new OkHttpClient();

    private static Log log = LogFactory.getLog(JiraHelper.class);

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
        String issuesLink = JIRA_BASE_URL + "browse/" + resp.getString("key");      // URL to created Jira ticket

        String issuesKey = resp.getString("key");
        log.info("Created Jira Issues: " + issuesLink);

        attachIssuesLink(issuesKey, issuesLink);

        return issuesLink;
    }
}