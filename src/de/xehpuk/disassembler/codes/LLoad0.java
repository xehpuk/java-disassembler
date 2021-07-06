package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LLoad0 extends LLoadAbstract {
	protected LLoad0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LLOAD_0;
	}
}