package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.Room;
import model.User;
import model.Reservation;
import model.ReservationDetails;

public class BookingRoomManager extends DataBaseManager {

	protected Object copyRecord(ResultSet rs) throws Exception{
		System.out.println("test");
		ReservationDetails rd = new ReservationDetails();

		rd.setRid(rs.getInt("RID"));

		int userRid = rs.getInt("UserRID");
		UserManager um=new UserManager();
		User user=um.getUser(userRid);
		rd.setUser(user);

		int roomRid = rs.getInt("RoomRID");
		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(roomRid);
		rd.setRoom(room);

		// 会議室場所を取得
		rd.setBuildingName(rs.getString("buildingName").trim());
		int floor = rs.getInt("Floor");
		rd.setFloor(floor);

		// 会議室名を取得
		rd.setRoomName(rs.getString("roomName").trim());

		// 利用時間を取得
		int startHour = rs.getInt("StartHour");
		int startMinute = rs.getInt("StartMinute");
		int periodHour = rs.getInt("PeriodHour");
		int periodMinute = rs.getInt("PeriodMinute");
		rd.setStartHour(startHour);
		rd.setStartMinute(startMinute);
		rd.setPeriodHour(periodHour);
		rd.setPeriodMinute(periodMinute);

		// ユーザ名を取得
		String userName = rs.getString("UserName").trim();
		rd.setUserName(userName);

		// emailAddressを取得
		String email = rs.getString("UserEmail").trim();
		rd.setEmailAddress(email);

		return rd;
	}

	// 予約情報を取得するメソッド
	public ReservationDetails getReservationDetail(int rid){
		String sql = "";
		sql += "Select * from ReservationDetailsInfo Where ";
		sql += " RID = "+rid;
		return (ReservationDetails)getRecord(sql);
	}

	// 予約リストを取得するメソッド
	public LinkedList<ReservationDetails> getReservationDetails(){
		String sql = "";
		sql += "Select * from ReservationDetailsInfo";

		return (LinkedList<ReservationDetails>)getRecords(sql);
	}
}
