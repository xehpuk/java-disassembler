package de.xehpuk.disassembler.codes;

public abstract class ALoadAbstract extends IndexedInstruction {
	protected ALoadAbstract(final int index) {
		super(index);
	}

	public static ALoadAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new ALoad0();
			case 1:
				return new ALoad1();
			case 2:
				return new ALoad2();
			case 3:
				return new ALoad3();
			default:
				return new ALoad(index);
		}
	}
}