package de.xehpuk.disassembler.codes;

public abstract class ILoadAbstract extends IndexedInstruction {
	protected ILoadAbstract(final int index) {
		super(index);
	}

	public static ILoadAbstract getInstance(final int index) {
		switch (index) {
			case 0:
				return new ILoad0();
			case 1:
				return new ILoad1();
			case 2:
				return new ILoad2();
			case 3:
				return new ILoad3();
			default:
				return new ILoad(index);
		}
	}
}