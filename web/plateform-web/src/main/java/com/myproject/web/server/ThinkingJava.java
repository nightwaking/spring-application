package com.myproject.web.server;

public class ThinkingJava {
	int i = 0;
	ThinkingJava increment() {
		i++;
		return this;
	}
	void print(){
		System.out.println("i = " + i);
	}

	public static void main(String[] args) {
		ThinkingJava x = new ThinkingJava();
		x.increment().increment().increment().print();
		new AppleMan().eat(new Apple());
	}
}

/**
 * 将当前对象传递给其他方法
 */
class AppleMan {
	public void eat (Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler {
	static Apple peel(Apple apple) {
		return  apple;
	}
}

class Apple {
	Apple getPeeled () {
		return Peeler.peel(this);
	}
}

class Book {
	boolean checkedOut = false;
	Book(boolean checkOut) {
		checkedOut = checkOut;
	}
	void checkIn() {
		checkedOut = false;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Error: checked out");
		super.finalize();
	}
}

class TerminationCondition {
	public static void main(String[] args) {
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc();
	}
}

class Window {
	Window(int marker) {
		System.out.println("Window(" + marker + ")");
	}
}

class House {
	Window window1 = new Window(1);
	House () {
		System.out.println("House()");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void fn() {
		System.out.println("fn()");
	}
	Window w3 = new Window(3);
}

class OrderOfInitialization {
	public static void main(String[] args) {
		House house = new House();
		house.fn();
	}
}

class Bowl {
	Bowl (int marker) {
		System.out.println("Bowl(" + marker + ")");
	}
	void f1(int marker) {
		System.out.println("f1(" + marker + ")");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1);
	Table (){
		System.out.println("Table()");
		bowl2.f1(1);
	}
	void f2(int marker){
		System.out.println("f2(" + marker + ")");
	}
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Cupboard() {
		System.out.println("Cupboard");
		bowl4.f1(2);
	}
	void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}
	static Bowl bowl5 = new Bowl(5);
}

class StaticInitialization {
	public static void main(String[] args) {
		System.out.println("print Cupboard in main");
		new Cupboard();
		System.out.println("print Cupboard in main");
		new Cupboard();
	}
	static Table table = new Table();
}

class SpliceTest {
	public static void main(String[] args) {
		String polePlace = "A";
		String[] polePlaces = polePlace.split(",");
		for (String place: polePlaces) {
			System.out.println(place);
		}
	}
}

