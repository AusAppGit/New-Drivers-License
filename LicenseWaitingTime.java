import java.util.*;

public class LicenseWaitingTime
  {
        public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          // initialise arraylists: 1st takes in string input, 2nd for the waiting room
          ArrayList<String> input = new ArrayList<String>();
          ArrayList<String> waitingList = new ArrayList<String>();
          
          // populate arraylist with input
          int x = 0;
          while(x != 3){
              String info = sc.nextLine();
              input.add(info);
              x++;
              }

          // start sorting out the information from input to use
          String myName = input.get(0);
          int workers = Integer.parseInt(input.get(1));
          String [] clients = input.get(2).split(" ");
          
          // populate arraylist with clients and user's name to sort
          int y = 0;
          while(y != 4){
              waitingList.add(clients[y]);
              y++;
              }
          waitingList.add(myName);
          Collections.sort(waitingList);

          // figure out waiting time depending on position in the waiting list and workers
          int itCount = 0;
          Iterator<String> it = waitingList.iterator();
          while(it.hasNext()){
              itCount++;
              if(it.next().equals(myName))
                {
                  break;
                }
              }
          // how many groups are formed by the agents
          double workersGrp1 = 5.0/workers;
          double workersGrp2 = Math.ceil(workersGrp1);
          int workGrpTtl = (int)workersGrp2;

          // because there are only ever 5 people waiting, the amount of groups is limited
          switch(itCount){
            case 1:
              System.out.println(20);
              break;
            case 2:
              if(workers == 1)
                {
                  System.out.println(40);
                }
               else{
                  System.out.println(20);
                }
                break;
              case 3:
                if(workers == 1)
                {
                  System.out.println(60);
                }
                else if(workers == 2)
                {
                  System.out.println(40);
                }
               else{
                  System.out.println(20);
                }
                break;
              case 4:
                if(workers == 1)
                {
                  System.out.println(80);
                }
                else if(workers == 2)
                {
                  System.out.println(60);
                }
                else if(workers == 3)
                {
                  System.out.println(40);
                }
               else{
                  System.out.println(20);
                }
                break;
              case 5:
                System.out.println(workGrpTtl*20);
                break;
              }
          
          sc.close();
      }
    }
