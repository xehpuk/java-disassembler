package de.xehpuk.disassembler.codes;

public class Wide2 extends Wide {
	private final short constant;

	public Wide2(final int index, final short constant) {
		super(index, OpCode.IINC);
		this.constant = constant;
	}

	public final short getConstant() {
		return constant;
	}
}