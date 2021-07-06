package de.xehpuk.disassembler.codes;

public abstract class LLoadAbstract extends IndexedInstruction {
	protected LLoadAbstract(final int index) {
		super(index);
	}

	public static LLoadAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new LLoad0();
			case 1:
				return new LLoad1();
			case 2:
				return new LLoad2();
			case 3:
				return new LLoad3();
			default:
				return new LLoad(index);
		}
	}
}