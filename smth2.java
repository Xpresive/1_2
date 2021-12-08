val queue = Volley.newRequestQueue(this)
        val url = "http://md5.jsontest.com/?text=example_text"
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                println(response)
                if (response != null) {
                    textView.text = "Response is: $response"
                }
            },
            { error ->
                println(error)
                textView.text = "That didn't work!"
            })

        queue.add(stringRequest)

private void sendHtmlRequest (){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        URL url = null;
        try {
            url = new URL("http://md5.jsontest.com/?text=example_text");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader is = new InputStreamReader(in);
        // read the JSON data
        BufferedReader reader = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                if(line.contains("md5"))
                {

                sb.append(line.substring(10) + "\n");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(sb.toString().equals(md5)){
            tekst.setText(md5 + "sutapo");
        }
        else if (md5.isEmpty()) {
            tekst.setText(md5 + "buvo tuscias");
            md5=sb.toString();
        }
        else{

            tekst.setText("Eilutes skiriasi");
/*
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.download)
                    .setContentTitle("MD5")
                    .setContentText("Skiriasi eilutes")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.


                    mNotificationManager.notify(001, builder.build());
                    */

           button.setVisibility(View.VISIBLE);
        }

        newmd5=sb.toString();



    }