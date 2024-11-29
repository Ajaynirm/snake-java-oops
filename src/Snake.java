import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private char[][] snakeBoard=new char[6][6];
    private Queue<Node> queueSnake=new LinkedList<>();
    private Queue<Node> food=new LinkedList<>();

    int row;
    int col;
    public Snake(int row,int col){
        this.row=row;
        this.col=col;
        queueSnake.offer(new Node(row,col));
        snakeBoard[row][col]='.';
        snakeBoard[0][3]='x';
        food.offer(new Node(3,3));
        food.offer(new Node(5,5));
        food.offer(new Node(2,2));
    }

    public int makeChange(int r,int c){
        int nrow=this.row+r;
        int ncol=this.col+c;
        if(nrow>=0 && nrow<snakeBoard.length && ncol>=0 && ncol<snakeBoard[0].length){
            queueSnake.offer(new Node(nrow,ncol));
            if(snakeBoard[nrow][ncol]=='.'){
                System.out.println("Game Over");
                return -1;
            }
            if(snakeBoard[nrow][ncol]=='x'){
                snakeBoard[nrow][ncol]='.';
                row=nrow;
                col=ncol;
                if(!food.isEmpty()){
                    Node dup=food.poll();
                    snakeBoard[dup.getRow()][dup.getCol()]='x';
                }else{
                    System.out.println("You Won 🏆");
                    return -1;
                }
            }else{
                Node delete=queueSnake.poll();
                int drow=delete.getRow();
                int dcol=delete.getCol();
                snakeBoard[drow][dcol]='\0';
                snakeBoard[nrow][ncol]='.';
                row=nrow;
                col=ncol;

            }

            printBoard();
            return 0;
        }else{
            System.out.println("Game Over");
            return -1;
        }
    }









    public void printBoard(){
        int n=snakeBoard.length;
        int m=snakeBoard[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(snakeBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
}
