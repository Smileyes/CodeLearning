/*
事先将歌曲相关信息编辑进入SongList.txt，从中提取出相关信息（集合），进行排序。
*/
import java.io.*;
import java.util.*;

class Song implements Comparable<Song>{
	private String name;
	private String artist;
	private String alumb;
	private String date;
	
	public Song(String a,String b,String c,String d){
		name = a;
		artist = b;
		alumb = c;
		date = d;
	}
	
	public String getName(){
		return name;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String toString(){
		return  name + "  " + artist + "  《" + alumb + "》  " + date + "\n";
	}
	
	public int compareTo(Song egg){
		return (name.compareTo(egg.getName()));
	}

	public boolean equals(Object obj){
		Song a = (Song)obj;
		return name.equals(a.getName());
	}
	
	public int hashCode(){
		return name.hashCode();
	}
}

public class TestSong{
	public static void main(String [] args){
		TestSong testSong = new TestSong();
		testSong.go();
	}
	
	public void go(){
		String st = null;
		ArrayList <Song> songList = new ArrayList <Song>();
		HashSet <Song> songList2 = new HashSet <Song> ();
		TreeSet <Song> songList3 = new TreeSet <Song> ();
		try{
			File f = new File("F:/JAVA/SongList/SongList.txt"); 
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((st = br.readLine()) != null){
				addSong(st,songList);
			}
			songList2.addAll(songList);
			songList3.addAll(songList);
			System.out.println(songList);
			System.out.println(songList2);
			System.out.println(songList3);
			/*Collections.sort(songList);
			System.out.println(songList);
			ArtistCompare artistCompare = new ArtistCompare();
			Collections.sort(songList,artistCompare);
			System.out.println(songList);*/
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ae){
			ae.printStackTrace();
		}
	}
	
	public void addSong(String st,ArrayList <Song> list){
		String [] song = st.split("/");
		list.add(new Song(song[0],song[1],song[2],song[3]));
	}
}

class ArtistCompare implements Comparator <Song>{
	 public int compare(Song o1,Song o2){
	 	return o1.getArtist().compareTo(o2.getArtist());
	 }
}

