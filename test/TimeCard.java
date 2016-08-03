import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;


public class TimeCard {
	
	public static void main(String args[]) {
		Recode recode = new Recode("TimeCard.txt");
		Input input = new Input();
		
		while(true){
			int key=input.requestKey();
			
			if(key==Input.START){
				recode.start();
			}
			else if(key==Input.FINISH){
				recode.finish();
			}
			else if(key==Input.PAUSE){
				recode.pause();
			}
			else if(key==Input.SHOW){
				recode.show();
			}
			else{
				if(recode.exit()) break;
			}
			System.out.println("");
		}
	}
}

class Recode{
	private Calendar calendar;
	private int y,m,d,h,min;	//開始したときの年、月、日、時間、分
	private int hour,minute,second;	//作業時間
	private long startTime, pauseTime, finishTime;	//作業時間
	private String document;	//メモ
	private int state;	//状態
	private File file;	//file
	private PrintWriter pw;	//書き込み用
	private BufferedReader br;	//読み込み用
	
	Recode(String filename){
		calendar = Calendar.getInstance();
		y=m=d=h=min=hour=minute=second=0;
		document="";
		state=Input.FINISH;
		file = new File(filename); 
	}
	
	public void start(){
		if(state==Input.FINISH){
			state=Input.START;
			y=calendar.get(Calendar.YEAR);
			m=calendar.get(Calendar.MONTH)+1;
			d=calendar.get(Calendar.DATE);
			h=calendar.get(Calendar.HOUR_OF_DAY);
			min=calendar.get(Calendar.MINUTE);
			startTime = System.currentTimeMillis();
			
			System.out.println("Start "+y+"/"+m+"/"+d+" "+h+":"+min);
		}
		else System.out.println("You have already started.");
	}
	
	public void finish(){
		if(state==Input.START){
			state=Input.FINISH;
			finishTime = (long)(System.currentTimeMillis() - startTime)/1000;
			hour = (int) (finishTime/60/60);
			minute = (int) (finishTime/60%60);
			second = (int) (finishTime%60);
			
			System.out.println("Working time "+hour+":"+minute+":"+second);
			System.out.println("Please write a note.");
			document = new Input().requestText();
			
			try {
				pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.println("DATE: "+y+"/"+m+"/"+d+" "+h+":"+min);
			pw.println("TIME: "+hour+":"+minute);
			pw.println(document);
			pw.println();
			pw.close();
		}
		else System.out.println("You have already finished or Pausing.");
	}
	
	public void pause(){
		if(state==Input.START){
			state=Input.PAUSE;
			pauseTime = System.currentTimeMillis();
			System.out.println("pause start");
		}
		else if(state==Input.PAUSE){
			state=Input.START;
			pauseTime = System.currentTimeMillis()-pauseTime;
			startTime += pauseTime;
			System.out.println("pause finish");
		}
		else System.out.println("You are not yet started");
	}
	
	public void show(){
		String str;
		try {
			br = new BufferedReader(new FileReader(file));
			while((str=br.readLine()) != null){
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exit(){
		if(state==Input.START){
			System.out.println("You are not yet finished");
			return false;
		}
		System.out.println("End.");
		return true;
	}
}

class Input{
	final static int START = 0;
	final static int FINISH = 1;
	final static int PAUSE = 2;
	final static int SHOW = 3;
	final static int EXIT = 4;
	private BufferedReader br;	//キーボードの入力用
	
	Input(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//コマンドを受け付ける
	public int requestKey(){
		String str="";	//キーボードの入力
		int key=-1;
		
		System.out.println("Pleas enter a key... 0:Start 1:Finish 2:Pause 3:Show　4:Exit");
		try {
			str=br.readLine();
			key=Integer.parseInt(str);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("It would have the wrong input");
			System.out.println();
			return requestKey();
		}
		
		if(key==START || key==FINISH || key==PAUSE || key==SHOW  || key==EXIT){
			return key;
		}
		else{
			System.out.println("It would have the wrong input");
			System.out.println();
			return requestKey();
		}
	}
	
	//テキストを受け付ける
	public String requestText(){
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}