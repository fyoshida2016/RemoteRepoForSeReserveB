package db;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import model.Reservation;
import model.Room;
import model.TestDataFactory;
import model.User;

public class ReservationManagerTest {

	@Test
	public void 予約を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story08/dbaccess_test.xls");

		// データベースから予約を読み込み
		ReservationManager rm = new ReservationManager();
		LinkedList<Reservation> reservations = rm.getReservations();

		// 読み込んだオブジェクトの数が適切かどうかをチェック
		assertThat(reservations.size(),is(2));

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		Reservation res1 = reservations.get(0);
		assertThat(res1.getRid(),is(1));
		assertThat(res1.getUser().getRid(),is(1));
		assertThat(res1.getRoom().getRid(),is(2));
		assertThat(res1.getStartYear(),is(2016));
		assertThat(res1.getStartMonth(),is(12));
		assertThat(res1.getStartDay(),is(5));
		assertThat(res1.getStartHour(),is(13));
		assertThat(res1.getStartMinute(),is(0));
		assertThat(res1.getPeriodHour(),is(1));
		assertThat(res1.getPeriodMinute(),is(30));

		Reservation res2 = reservations.get(1);
		assertThat(res2.getRid(),is(2));
		assertThat(res2.getUser().getRid(),is(2));
		assertThat(res2.getRoom().getRid(),is(5));
		assertThat(res2.getStartYear(),is(2016));
		assertThat(res2.getStartMonth(),is(1));
		assertThat(res2.getStartDay(),is(1));
		assertThat(res2.getStartHour(),is(1));
		assertThat(res2.getStartMinute(),is(1));
		assertThat(res2.getPeriodHour(),is(2));
		assertThat(res2.getPeriodMinute(),is(30));
	}

}

