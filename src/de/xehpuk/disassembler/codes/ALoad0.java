package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ALoad0 extends ALoadAbstract {
	protected ALoad0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ALOAD_0;
	}
}