package de.xehpuk.disassembler.codes;

public abstract class FLoadAbstract extends IndexedInstruction {
	protected FLoadAbstract(final int index) {
		super(index);
	}

	public static FLoadAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new FLoad0();
			case 1:
				return new FLoad1();
			case 2:
				return new FLoad2();
			case 3:
				return new FLoad3();
			default:
				return new FLoad(index);
		}
	}
}