package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FLoad2 extends FLoadAbstract {
	protected FLoad2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FLOAD_2;
	}
}