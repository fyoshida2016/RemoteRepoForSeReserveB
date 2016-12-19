package db;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import model.ReservationDetails;

public class BookingRoomManagerTest {

	@Test
	public void 予約詳細を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db = new TestDataBase();
		db.setTestData("./testdata/story09/bookingRoomManagerTest.xls");

		BookingRoomManager brm = new BookingRoomManager();

		// データベースから予約を読み込み
		ReservationDetails rd = brm.getReservationDetail(1);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(rd.getRid(), is(1));
		assertThat(rd.getBuildingName(), is("物質・材料経営情報棟"));
		assertThat(rd.getFloor(), is(2));
		assertThat(rd.getStartHour(), is(13));
		assertThat(rd.getStartMinute(), is(0));
		assertThat(rd.getPeriodHour(), is(1));
		assertThat(rd.getPeriodMinute(), is(30));
		assertThat(rd.getUserName(), is("Mr.x"));
		assertThat(rd.getEmailAddress(), is("mrx@gmail.com"));

		LinkedList<ReservationDetails> rds = brm.getReservationDetails();

		// 読み込んだオブジェクトの数が適切かどうかをチェック
		assertThat(rds.size(), is(2));

		ReservationDetails rd1 = rds.get(0);
		assertThat(rd1.getRid(), is(1));
		assertThat(rd1.getBuildingName(), is("物質・材料経営情報棟"));
		assertThat(rd1.getFloor(), is(2));
		assertThat(rd1.getRoomName(), is("ゼミ室"));
		assertThat(rd1.getStartHour(), is(13));
		assertThat(rd1.getStartMinute(), is(0));
		assertThat(rd1.getPeriodHour(), is(1));
		assertThat(rd1.getPeriodMinute(), is(30));
		assertThat(rd1.getUserName(), is("Mr.x"));
		assertThat(rd1.getEmailAddress(), is("mrx@gmail.com"));

		ReservationDetails rd2 = rds.get(1);
		assertThat(rd2.getRid(), is(2));
		assertThat(rd2.getBuildingName(), is("総合研究棟"));
		assertThat(rd2.getFloor(), is(6));
		assertThat(rd2.getRoomName(), is("ゼミ室"));
		assertThat(rd2.getStartHour(), is(1));
		assertThat(rd2.getStartMinute(), is(1));
		assertThat(rd2.getPeriodHour(), is(2));
		assertThat(rd2.getPeriodMinute(), is(30));
		assertThat(rd2.getUserName(), is("Ms.z"));
		assertThat(rd2.getEmailAddress(), is("msz@gmail.com"));


	}

}
