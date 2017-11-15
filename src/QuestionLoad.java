import java.io.*;

public class QuestionLoad {

    private BufferedReader file;

    public void LoadQuestionFile() {
        try {
            FileInputStream fstream = new FileInputStream("q.txt");
            file = new BufferedReader(new InputStreamReader(fstream, "CP1251"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question GetQuestion() {
        Question returnValue = null;
        try {
            String stringQuestion = file.readLine();
            if (stringQuestion == null) {
                return null;}
                if (!stringQuestion.isEmpty()) {
                    String[] tmpStringArray = stringQuestion.split("#");
                    returnValue = new Question();
                    returnValue.answer = tmpStringArray[1];
                    returnValue.question = tmpStringArray[0];
                }
            } catch(IOException e){
                e.printStackTrace();
            }
            return returnValue;
        }

    public void CloseQuestionFile() {
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
