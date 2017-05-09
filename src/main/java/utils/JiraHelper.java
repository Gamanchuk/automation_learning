package utils;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static utils.CommonFunctions.attachIssuesLink;


public class JiraHelper {
    //TODO: Change OAuth access tokens, url, project key
    private final static String AUTH_HEADER = "c2hhcG92YWxvdmVpOlRlc3RlcjEyMzQ=";
    private final static String JIRA_BASE_URL = "https://moovweb.atlassian.net/";
    private final static String JIRA_URL = JIRA_BASE_URL + "rest/api/2";
    private final static String PROJECT_KEY = "AUTO";

    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
    private static final MediaType MEDIA_MULTIPART = MediaType.parse("multipart/form-data");
    private final static OkHttpClient client = new OkHttpClient();

    private static Log log = LogFactory.getLog(JiraHelper.class.getSimpleName());

    public static String publishJira(String title, String description, String environment, String expectedResult, String actualResult) throws JSONException, IOException {

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
        fields.put("customfield_12701", expectedResult);
        fields.put("customfield_12700", actualResult);
        fields.put("environment", environment);

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
        String issueKey = resp.getString("key");
        String issueLink = doLinkToIssue(issueKey);   // URL to created Jira ticket

        log.info("Created Jira Issue: " + issueLink);
        attachIssuesLink(issueKey, issueLink);

        return issueKey;
    }

    public static String doLinkToIssue(String ticketId) {
        return JIRA_BASE_URL + "browse/" + ticketId;
    }

    public static void addAttachment(String issueKey, File file) throws IOException {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getAbsolutePath(), RequestBody.create(MEDIA_MULTIPART, file))
                .build();

        Request request = new Request.Builder()
                .url(JIRA_URL + "/issue/"+ issueKey +"/attachments")
                .header("X-Atlassian-Token", "nocheck")
                .header("Authorization", "Basic " + AUTH_HEADER)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        log.info("Attached html source to " + issueKey);
        log.info(response.body().string());

}

}