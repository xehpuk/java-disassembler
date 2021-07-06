package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FLoad0 extends FLoadAbstract {
	protected FLoad0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FLOAD_0;
	}
}