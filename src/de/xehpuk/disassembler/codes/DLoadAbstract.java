package de.xehpuk.disassembler.codes;

public abstract class DLoadAbstract extends IndexedInstruction {
	protected DLoadAbstract(final int index) {
		super(index);
	}

	public static DLoadAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new DLoad0();
			case 1:
				return new DLoad1();
			case 2:
				return new DLoad2();
			case 3:
				return new DLoad3();
			default:
				return new DLoad(index);
		}
	}
}