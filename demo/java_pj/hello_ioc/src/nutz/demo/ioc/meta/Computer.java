package nutz.demo.ioc.meta;

import org.nutz.lang.Strings;

import static java.lang.System.*;

public class Computer {

	private CPU cpu;

	private DDR2_800_2G memory;

	private int others;

	private int getPrice() {
		return cpu.getPrice() + memory.getPrice() + others;
	}

	public void printBrief() {
		out.println(Strings.dup('=', 40));
		out.println("Computer brief:");
		out.println(Strings.dup('~', 40));
		print("CPU", cpu);
		print("Memory", memory);
		out.printf("%10s : $%d\n", "Others", others);
		out.println(Strings.dup('-', 40));
		out.printf("%10s : %d RMB\n", "Total", this.getPrice());
		out.println(Strings.dup('=', 40));
	}

	private void print(String name, Component com) {
		out.printf("%10s : %s = %d RMB\n", name, com.getClass().getSimpleName(), com.getPrice());
	}

	public CPU getCPU() {
		return cpu;
	}

	public DDR2_800_2G getMemory() {
		return memory;
	}

	public void init() {
		System.out.println("I am initializing ...");
	}

	public void depose() {
		System.out.println("I am done!");
	}

}
