import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Snake snake=new Snake(0,0);
        snake.printBoard();

        boolean loop=true;
        Scanner in=new Scanner(System.in);
        while(loop){
            System.out.println(
                    "Enter Key\n"+
                    "Up-u \t Down-d \tLeft-l \tRight-r"
            );
            char key=in.next().charAt(0);
            switch (key){
                case 'u':
                    int res=snake.makeChange(-1,0);
                    if(res==-1) loop=false;
                    break;
                case 'd':
                     res=snake.makeChange(1,0);
                    if(res==-1) loop=false;
                    break;
                case 'r':
                    res=snake.makeChange(0,1);
                    if(res==-1) loop=false;
                    break;
                case 'l':
                    res=snake.makeChange(0,-1);
                    if(res==-1) loop=false;
                    break;
                default:
                    System.out.println("Enter valid key");
            }
        }
    }
}



