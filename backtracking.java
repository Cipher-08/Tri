import java.util.ArrayList;

public class backtracking {
    public static void main(String[] args) {
        // System.out.println(count(4, 4));
        boolean[][] board ={
          {true,true,true},
          {true,true,true},
          {true,true,true}

        };
        backTrackingFinal(board, 0, 0, "");
    }   
    

  public static int count(int r , int c){
    if(r==1 || c==1)return 1;
    int left = count(r-1, c);
    int right = count(r, c-1);

    return left+right;
  }



  static void path(String p , int r, int c){
    if(r==1 && c==1){
        System.out.println(p);
        return;
    }
    if(r>1){
        path(p+'D', r-1, c);
    } 
    if(c>1){
     path(p+'R', r, c-1);
    }
  }




   static ArrayList<String> pathList(String p , int r, int c){
    if(r==1 && c==1){
        ArrayList<String> list=new ArrayList<>();
        list.add(p);
        return list;
    }
     ArrayList<String> list = new ArrayList<>();  
    if(r>1 && c>1){
      list.addAll(pathList(p+'D', r-1, c-1));
    }
    if(r>1){
         list.addAll(pathList(p+'H', r-1, c));     
    } 
    if(c>1){
      list.addAll(pathList(p+'V', r, c-1));
    }
   return list;
  }



  static void mazeProb(boolean[][] maze , int r , int c , String p){
    if(r==maze.length-1 &&c==maze[0].length-1){
      System.out.println(p);
      return;
    }
    if(!maze[r][c]){
      return;
      /////Backtracking : Return from or stop the rec from that call
    }/////
    if(r<maze.length-1){
       mazeProb(maze, r+1, c, p+'D');
    }
    if(c<maze[0].length-1){
      mazeProb(maze, r, c+1, p+'R');
    }
    if(c<maze[0].length-1 && r<maze.length-1){
      mazeProb(maze, r+1, c+1, p+'U');
    }
  }


  ///Backtracking 

    static void backTrackingFinal(boolean[][] maze , int r , int c , String p){
    if(r==maze.length-1 &&c==maze[0].length-1){
      System.out.println(p);
      return;
    }
    if(!maze[r][c]){
      return;
    }

      ////here the path generation starts 
    ////so we can mark the path as false 

    maze[r][c]=false;

    if(r<maze.length-1){
       backTrackingFinal(maze, r+1, c, p+'D');
    }
    if(c<maze[0].length-1){
      backTrackingFinal(maze, r, c+1, p+'R');
    }
    if(c > 0){
       backTrackingFinal(maze, r, c-1, p+'L');
    }
    if(r>0){
      backTrackingFinal(maze, r-1, c, p+'U');
    }

    maze[r][c]=true;
    }
  }

    

