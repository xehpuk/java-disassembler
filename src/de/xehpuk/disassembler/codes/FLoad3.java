package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FLoad3 extends FLoadAbstract {
	protected FLoad3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FLOAD_3;
	}
}