package model;

public class ReservationDetails {

	private int rid;
	private User user;
	private Room room;
	private int startHour;
	private int startMinute;
	private int periodHour;
	private int periodMinute;
	private String userName;
	private String emailAddress;
	private String buildingName;
	private int floor;
	private String roomName;

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	public int getPeriodHour() {
		return periodHour;
	}
	public void setPeriodHour(int periodHour) {
		this.periodHour = periodHour;
	}
	public int getPeriodMinute() {
		return periodMinute;
	}
	public void setPeriodMinute(int periodMinute) {
		this.periodMinute = periodMinute;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
