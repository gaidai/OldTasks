
package fivetasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author S.Gaidai
 */
public class OldTasks {


    public static void main(String[] args) {
        
        // Change values of two variables, without third.
        taskOne(3 , 8);
        
        // Find the sum of first N Fibonacci numbers
        taskTwo(18);
        
        //  Find a numbers of floar , block 
        // and № of door at the floar for absolute flat's number
        // in building with 9 floars, 4 doors at each floar        
        taskThree(73);
        
        // Find the year of nearest Saturday 27 June        
        taskFive(27, 6, 7);
    }
    
    public static void taskOne(int x, int y){    
        System.out.println("Task 1");
        System.out.println("Start: x = " + x + "; y = " + y);
        x = x - y;
        y = y + x;
        x = y - x;
        System.out.println("Result: x = " + x + "; y = " + y);        
    }
    
    public static void taskTwo(int n){
        System.out.println();
        System.out.println("Task 2");
        int [] fibonacci = new int [n];
        fibonacci[0]= 0;
        int temp = 0;
        int sum = 0;
        //Fill array with fibonacci numbers         
        for( int i = 1; i<n ; i++){
            if ( i-2 <0){
                fibonacci[i] = 1;
            }else{
                fibonacci[i] =  fibonacci[i-1] +  fibonacci[i-2];
            }
        }
        for(int k: fibonacci){
            System.out.print( k + " ");
            sum += k ;
        }
        System.out.println();
        System.out.println("Sum of first " + n + " Fibonacci numbers : " + sum);        
    }
    
    
    public static void taskThree(int flat){
        System.out.println();
        System.out.println("Task 3");
        final int floars = 9, 
                  doors = 4 ;
        int block, floar , door, flatsInBlock , tempNumberInBlock;
        flatsInBlock = floars * doors;
        
        
        if(flat%flatsInBlock == 0){
            block = flat/flatsInBlock ;
            tempNumberInBlock = flatsInBlock;
        }else{
            block = flat/flatsInBlock + 1; 
            tempNumberInBlock = flat%flatsInBlock;
        }    
        
        if(tempNumberInBlock%4 == 0 ){
            floar = tempNumberInBlock/4 ;
        }else{
            floar = tempNumberInBlock/4 + 1 ;
        }
        door = tempNumberInBlock - 4*(floar-1);
        System.out.println("Flat №"+ flat + " can be fined at:");

        System.out.println("Block: " + block + ", floar: " + floar + ", door: "+ door);
    }    
    
    public static void taskFive(int dayOfMonth, int month, int dayOfWeek){ 
        System.out.println();
        System.out.println("Task 5");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM => yyyy ",  Locale.US);	
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime(); 
        // Set searching date
        cal.set(Calendar.MONTH, month -1);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        
        Date tempDate = cal.getTime();  
        //Check that it is a future date
        if (today.after(tempDate)){
            cal.add(Calendar.YEAR, 1);            
        }
        //Move to next year and compare the dayOfWeek
        while (cal.get(Calendar.DAY_OF_WEEK) != dayOfWeek){
            cal.add(Calendar.YEAR, 1); 
        }
        tempDate = cal.getTime();      
	System.out.println( "Nearest : " + dateFormat.format(tempDate) );    
 
    }
   
}
