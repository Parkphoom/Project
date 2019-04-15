package com.example.testdialogflow;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.cloud.dialogflow.v2beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.v2beta1.SessionName;
import com.google.cloud.dialogflow.v2beta1.SessionsClient;

import java.util.UUID;

import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class MainChat extends AppCompatActivity {

    private static final String TAG = MainChat.class.getSimpleName();
    private static final int USER = 1;
    private static final int BOT = 2;
    int countBoredWord = 0;

    private String uuid = UUID.randomUUID().toString();
    private LinearLayout chatLayout;
    private EditText queryEditText;

    // Android client
    private AIRequest aiRequest;
    private AIDataService aiDataService;
    private AIServiceContext customAIServiceContext;

//     Java V2
    private SessionsClient sessionsClient;
    private SessionName session;

    //Client access token
    private String NewAgent = "d8b39ac31def4f289e2c058bcf4c29f1";
    private String AgentforTest = "6dd62d5eb4bc416f9cd2927a0db632bd";
    private String ApiToken ="";
    //     howto change ApiToken
    //    //           ApiToken = AgentforTest;
    //    //            initChatbot();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ScrollView scrollview = findViewById(R.id.chatScrollView);
        scrollview.post(() -> scrollview.fullScroll(ScrollView.FOCUS_DOWN));

        chatLayout = findViewById(R.id.chatLayout);



        ImageView sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this::sendMessage);


        queryEditText = findViewById(R.id.queryEditText);
        queryEditText.setOnKeyListener((view, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_ENTER:
                        sendMessage(sendBtn);
                        return true;
                    default:
                        break;
                }
            }
            return false;
        });

        // Android client
        ApiToken = NewAgent;
       initChatbot();
        start();
        // Java V2
        //initV2Chatbot();


    }


    private void start(){
//        AlertDialog.Builder alertdialogBulider = new AlertDialog.Builder(MainChat.this);
//        alertdialogBulider
//                .setMessage("มาเริ่มกันเลยมั้ย")
//                .setCancelable(false)
//                .setPositiveButton("ตกลง",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                    String msg = "มาเริ่มกันเลยยยยย";
//                                        showTextView(msg, USER);
//                                        queryEditText.setText("");
//                                        // Android client
//                                        aiRequest.setQuery(msg);
//                                        RequestTask requestTask = new RequestTask(MainChat.this, aiDataService, customAIServiceContext);
//                                        requestTask.execute(aiRequest);
//
//
//
//                            }
//                        });
//        AlertDialog alertDialog = alertdialogBulider.create();
//        alertDialog.show();

        String msg = "Mi4lko6";
        queryEditText.setText("");
        // Android client
        aiRequest.setQuery(msg);
        RequestTask requestTask = new RequestTask(MainChat.this, aiDataService, customAIServiceContext);
        requestTask.execute(aiRequest);
    }

    private void initChatbot(){
        final AIConfiguration config = new AIConfiguration(ApiToken,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiDataService = new AIDataService(this,config);
        customAIServiceContext = AIServiceContextBuilder.buildFromSessionId(uuid);
        aiRequest = new AIRequest();

    }
//    private void initV2Chatbot() {
//        try {
//            InputStream stream = getResources().openRawResource(R.raw.test_agent_credentials);
//            GoogleCredentials credentials = GoogleCredentials.fromStream(stream);
//            String projectId = ((ServiceAccountCredentials)credentials).getProjectId();
//
//            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
//            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
//            sessionsClient = SessionsClient.create(sessionsSettings);
//            session = SessionName.of(projectId, uuid);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }




    private void sendMessage(View view) {
        String msg = queryEditText.getText().toString();

        if (msg.trim().isEmpty()) {
            Toast.makeText(MainChat.this, "พิมพ์อะไรสักหน่อยซิ!", Toast.LENGTH_LONG).show();
        } else {
            showTextView(msg, USER);
            queryEditText.setText("");
            // Android client
            aiRequest.setQuery(msg);
            RequestTask requestTask = new RequestTask(MainChat.this, aiDataService, customAIServiceContext);
            requestTask.execute(aiRequest);


            // Java V2
            //QueryInput queryInput = QueryInput.newBuilder().setText(TextInput.newBuilder().setText(msg).setLanguageCode("en-US")).build();
            //new RequestJavaV2Task(MainChat.this, session, sessionsClient, queryInput).execute();
        }
    }

    public void callback(AIResponse aiResponse) {
        if (aiResponse != null) {
            // process aiResponse here
            String botReply = aiResponse.getResult().getFulfillment().getSpeech();
//            String botReply2 = aiResponse.getResult().getMetadata().getIntentName();
            String botReplyDisplay = aiResponse.getResult().getMetadata().getIntentName();
//               Toast.makeText(MainChat.this, ApiToken, Toast.LENGTH_LONG).show();

            Log.d(TAG, "Bot Reply: " + botReply);
            showTextView(botReply, BOT);

            if(String.valueOf(aiResponse.getResult().getMetadata().getIntentName()).equals("detect_เบื่อ")){
                detectBoredWord();
            }
        } else {
            Log.d(TAG, "Bot Reply: Null");
            showTextView("There was some communication issue. Please Try again!", BOT);
        }
    }



    public void callbackV2(DetectIntentResponse response) {
        if (response != null) {
            // process aiResponse here
            String botReply = response.getQueryResult().getFulfillmentText();
            Log.d(TAG, "V2 Bot Reply: " + botReply);
            showTextView(botReply, BOT);
        } else {
            Log.d(TAG, "Bot Reply: Null");
            showTextView("There was some communication issue. Please Try again!", BOT);
        }
    }

    private void showTextView(String message, int type) {
        FrameLayout layout;
        switch (type) {
            case USER:
                layout = getUserLayout();
                break;
            case BOT:
                layout = getBotLayout();
                break;
            default:
                layout = getBotLayout();
                break;
        }
        layout.setFocusableInTouchMode(true);
        chatLayout.addView(layout); // move focus to text view to automatically make it scroll up if softfocus
        TextView tv = layout.findViewById(R.id.chatMsg);
        tv.setText(message);
        layout.requestFocus();
        queryEditText.requestFocus(); // change focus back to edit text to continue typing

    }

    private void detectBoredWord(){

        countBoredWord++;
        if(countBoredWord == 5){
            countBoredWord = 0;

            AlertDialog.Builder alertdialogBulider = new AlertDialog.Builder(MainChat.this);
              alertdialogBulider
                .setMessage("คุณอายุต่ำกว่า 19 ใช่หรือไม่")
                .setCancelable(false)
                      .setPositiveButton("ใช่",
                              new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      Intent i = new Intent(MainChat.this,MainQuiz9.class);
                                      startActivity(i);
                                  }
                              })
                      .setNegativeButton("ไม่ใช่", null);
        AlertDialog alertDialog = alertdialogBulider.create();
        alertDialog.show();
        }
    }



    FrameLayout getUserLayout() {
        LayoutInflater inflater = LayoutInflater.from(MainChat.this);
        return (FrameLayout) inflater.inflate(R.layout.user_msg_layout, null);
    }

    FrameLayout getBotLayout() {
        LayoutInflater inflater = LayoutInflater.from(MainChat.this);
        return (FrameLayout) inflater.inflate(R.layout.bot_msg_layout, null);
    }


}
