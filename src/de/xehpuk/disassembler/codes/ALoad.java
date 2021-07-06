package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ALoad extends ALoadAbstract {
	protected ALoad(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ALOAD;
	}
}