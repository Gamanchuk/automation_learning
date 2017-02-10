package utils;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringWriter;


public class TestRailRunHelper {
    private final static String LOGIN = "shapovalovei@softesis.com";
    private final static String PASSWORD = "Tester1234";
    private final static String CREDENTIALS = Credentials.basic(LOGIN, PASSWORD);
    private final static String TESTRAIL_URL = "https://moovweb.testrail.net/index.php?/api/v2/";
    private final static int PROJECT_ID = 30;

    private final static MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
    private final static OkHttpClient client = new OkHttpClient();

    private static int testRunId;

    private static TestRailRunHelper ourInstance = null;

    private static Log log = LogFactory.getLog(TestRailRunHelper.class);

    public static TestRailRunHelper getInstance() {
        if (ourInstance == null) {
            ourInstance = new TestRailRunHelper();
        }
        return ourInstance;
    }

    private TestRailRunHelper() {
    }


    public void startRun(String title) throws JSONException, IOException {

        int suite_id = Integer.parseInt(System.getProperty("suite.id"));
        log.info("Create run in TestRail: [ " + title + " ]");

        JSONObject data = new JSONObject();
        data.put("name", title);
        data.put("include_all", true);
        data.put("suite_id", suite_id);

        StringWriter out = new StringWriter();
        data.write(out);

        Request request = new Request.Builder()
                .url(TESTRAIL_URL + "add_run/" + PROJECT_ID)
                .header("Authorization", CREDENTIALS)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, out.toString()))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        JSONObject resp = new JSONObject(response.body().string());
        testRunId = resp.getInt("id");
    }

    public void setTestResult(int caseId, TestRailStatus status, String comment, String defects) throws JSONException, IOException {

        log.info("Update status TestCase: " + caseId + " on [" +status+ "]");

        JSONObject data = new JSONObject();
        data.put("status_id", status.statusId);
        data.put("comment", comment);
        data.put("defects", defects);

        StringWriter out = new StringWriter();
        data.write(out);

        Request request = new Request.Builder()
                .url(TESTRAIL_URL + "add_result_for_case/" + testRunId + "/" + caseId)
                .header("Authorization", CREDENTIALS)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, out.toString()))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
