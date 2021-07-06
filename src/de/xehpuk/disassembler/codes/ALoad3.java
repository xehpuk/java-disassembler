package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ALoad3 extends ALoadAbstract {
	protected ALoad3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ALOAD_3;
	}
}