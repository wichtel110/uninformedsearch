import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int arr[] = {2,8,3,1,6,4,7,0,5};
       int goalArr[] = {1,2,3,8,0,4,7,6,5};
       // int goalArr[] = {2,8,3,1,6,4,0,7,5};


        Node head = new Node(arr);

        head.printArr();
        head.expandMoves();

        dfsSearch(head, goalArr);


       // for(int i = 0; i < head.getChildList().size(); i++ ){
      //      head.getChildList().get(i).printArr();
     //   }
      //  System.out.println("Done!");



    }


    public static void bfsSearch(Node head, int goalArr[])
    {
        boolean goalFound = false;
        Queue<Node> q = new LinkedList<>();
        List<Node> childNode = new LinkedList<>();
        q.add(head);

        List<Node> pathToSolution = new LinkedList<>();
        List<Node> openList = new LinkedList<>();
        List<Node> closedList = new LinkedList<>();
        int count = 0;
        openList.add(head);

        while(!q.isEmpty() && !goalFound)
        {
            Node currentNode = q.remove();
            currentNode.expandMoves();
            count++;
            for(int i = 0; i < currentNode.getChildList().size(); i++)
            {
                Node currentChild = currentNode.getChildList().get(i);
                if(currentChild.checkIfSame(goalArr))
                {
                    goalFound = true;
                    System.out.println("Finished");
                    System.out.println("Counter: " + count);
                    currentChild.printArr();
                    break;
                }

                q.add(currentChild);
                currentChild.printArr();
            }

        }





//        while(openList.size() > 0 && !goalFound)
//        {
//            Node currentNode = openList.get(0);
//            closedList.add(currentNode);
//            openList.remove(0);
//            count++;
//            currentNode.expandMoves();
//
//            for(int i = 0; i < currentNode.getChildList().size(); i++)
//            {
//                Node currentChild = currentNode.getChildList().get(i);
//                if(currentChild.checkIfSame(goalArr) && !goalFound)
//                {
//                    System.out.println("Finish");
//                    System.out.println("Count: " + count);
//
//                    currentChild.printArr();
//                    goalFound = true;
//                    break;
//                }
//
//                if(checkList(openList,currentChild) && checkList(closedList,currentChild))
//                {
//                    openList.add(currentChild);
//                    System.out.println("added");
//                    currentChild.printArr();
//                }
//            }
//        }

//
//        while(!q.isEmpty() && !goalFound)
//        {
//            Node currentNode = q.remove();
//            closedList.add(currentNode);
//            currentNode.expandMoves();
//
//            for(int i = 0; i < currentNode.getChildList().size(); i++)
//            {
//                Node currentChild = currentNode.getChildList().get(i);
//                if(currentChild.checkIfSame(goalArr))
//                {
//                    System.out.println("Finish");
//                    currentChild.printArr();
//                    goalFound = true;
//                    break;
//                }
//
//                if(checkQueue(q,currentChild) && checkList(closedList,currentChild))
//                {
//                    q.add(currentChild);
//                    System.out.println("added");
//                    currentChild.printArr();
//                }
//
//            }
//        }
    }


    public static void dfsSearch(Node head, int goalArr[]){
        boolean goalFound = false;
        int count = 0;
        Stack<Node> s = new Stack<>();
        List<Node> visitedList = new LinkedList<>();
        s.push(head);


        while (!s.isEmpty() && !goalFound) {
            Node currentNode = s.peek();
            visitedList.add(s.pop());
            currentNode.expandMoves();
            count++;
            for(int i = 0; i < currentNode.getChildList().size();i++)
            {
                Node currentChild = currentNode.getChildList().get(i);
                if(currentChild.checkIfSame(goalArr))
                {
                    goalFound = true;
                    System.out.println("Finished");
                    System.out.println("Counter: " + count);
                    currentChild.printArr();
                    break;
                }

                if(checkList(visitedList,currentChild)){
                    s.push(currentChild);
                    currentChild.printArr();
                }
            }
        }
    }

    public static boolean checkList(List<Node> list, Node n){
        boolean contains = true;

        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).checkIfSame(n.getPuzzle()))
                return false;
        }

        return contains;
    }
}
