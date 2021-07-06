package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FLoad extends FLoadAbstract {
	protected FLoad(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FLOAD;
	}
}