package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LLoad1 extends LLoadAbstract {
	protected LLoad1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LLOAD_1;
	}
}