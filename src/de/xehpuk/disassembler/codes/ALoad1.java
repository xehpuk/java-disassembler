package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ALoad1 extends ALoadAbstract {
	protected ALoad1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ALOAD_1;
	}
}