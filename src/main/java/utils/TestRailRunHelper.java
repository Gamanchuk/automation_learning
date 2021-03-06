package utils;

import okhttp3.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.List;


public class TestRailRunHelper {
    private final static String LOGIN = "shapovalovei@softesis.com";
    private final static String PASSWORD = "Tester1234";
    private final static String CREDENTIALS = Credentials.basic(LOGIN, PASSWORD);
    private final static String TESTRAIL_URL = "https://moovweb.testrail.net/index.php?/api/v2/";
    private static int PROJECT_ID;

    private final static MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
    private final static OkHttpClient client = new OkHttpClient();

    private static int testRunId;

    private static TestRailRunHelper ourInstance = null;

    private static Log log = LogFactory.getLog(TestRailRunHelper.class.getSimpleName());

    public static TestRailRunHelper getInstance() {
        if (ourInstance == null) {
            ourInstance = new TestRailRunHelper();
        }
        return ourInstance;
    }

    private TestRailRunHelper() {
    }


    public void startRun(String title) throws JSONException, IOException {
        if (new File("target/testRailId").exists()) {
            List<String> lines = FileUtils.readLines(new File("target/testRailId"), "UTF-8");
            testRunId = Integer.parseInt(lines.get(0));
            log.info("Get suite id from cache: " + testRunId);
        } else {
            int suite_id = Integer.parseInt(System.getProperty("suite.id"));
            PROJECT_ID = Config.TESTRAIL_PROJECT_ID;
            log.info("Suite id: " + PROJECT_ID);

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

            createFileWithRunID(testRunId);
            log.info(String.format("TestRail run created. TestRun id: %d", testRunId));
        }
    }

    private void createFileWithRunID(int testRunId) {
        try {
            PrintWriter writer = new PrintWriter("target/testRailId", "UTF-8");
            writer.println(testRunId);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            log.error("Can`t create file with testRun id");
        }
    }

    public void setTestResult(String caseId, TestRailStatus status, String comment, String defects) throws JSONException, IOException {

        log.info("Updating TestCase: " + caseId + " on [" + status + "]");

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

        log.info("TestCase updated.");
    }
}
