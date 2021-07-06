package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ALoad2 extends ALoadAbstract {
	protected ALoad2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ALOAD_2;
	}
}