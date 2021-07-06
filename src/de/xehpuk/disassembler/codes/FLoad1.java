package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FLoad1 extends FLoadAbstract {
	protected FLoad1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FLOAD_1;
	}
}