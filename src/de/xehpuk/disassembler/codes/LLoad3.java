package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LLoad3 extends LLoadAbstract {
	protected LLoad3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LLOAD_3;
	}
}