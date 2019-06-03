package kr.or.ddit.nn.service.music;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DownServiceImpl extends UnicastRemoteObject implements DownService {
	private static DownServiceImpl service;
	
	private DownServiceImpl() throws RemoteException {
		super();
	}
	
	public static DownService getInstance() throws RemoteException {
		if(service == null) {
			service = new DownServiceImpl();
		}
		return service;
	}
	
	public void downloadMp3(File selectFile, String savePath) throws RemoteException {
		String musicName = null;
		String musicPath = null;
		FileOutputStream fout = null;
		
		System.out.println("OPEN:" + selectFile.getPath());
		musicPath = selectFile.getPath();
		musicName = selectFile.getName();
		System.out.println(savePath + "\\" + musicName);

		try {
			int c;
			fout = new FileOutputStream(savePath + "\\" + musicName);
			BufferedOutputStream fos = new BufferedOutputStream(fout, 24);
			FileInputStream fin = new FileInputStream(musicPath);
			BufferedInputStream bis = new BufferedInputStream(fin, 24);
			int cnt = 0;
			while ((c = bis.read()) != -1) {
				cnt++;
				fos.write(c);
			}
			System.out.println(cnt);
			bis.close();
			fos.close();
			fout.close();
			fin.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMp3() {
		
	}

}
