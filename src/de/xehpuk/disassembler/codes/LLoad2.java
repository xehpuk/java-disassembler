package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LLoad2 extends LLoadAbstract {
	protected LLoad2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LLOAD_2;
	}
}