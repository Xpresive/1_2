public class MainActivity extends AppCompatActivity {
TextView texx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="http://md5.jsontest.com/?text=example_text";

        texx = findViewById(R.id.tex1);
        Button button = findViewById(R.id.but1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new example().execute();
            }
        });

    }

    public class example extends AsyncTask<Void, Void, Void>{
        String words;

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("http://md5.jsontest.com/?text=example_text%22).ignoreContentType(true).get();
                words = doc.text();
                processGetText(words);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            texx.setText(words);
        }
    }
    public void processGetText(String words){
        System.out.println(words);
    }

}