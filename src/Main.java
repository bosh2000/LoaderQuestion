public class Main {

    public static void main(String[] args) {
        MysqlDao my=new MysqlDao();
        QuestionLoad qLoad=new QuestionLoad();
        qLoad.LoadQuestionFile();
        Question question;

        int index=0;
        while ((question=qLoad.GetQuestion())!=null){
            my.AddQuestionToBase(question,index);
            index++;
        }
        System.out.println(String.format("Procesed %d string.",index));
        qLoad.CloseQuestionFile();
        my.Close();

    }
}
