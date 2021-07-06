package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ILoad2 extends ILoadAbstract {
	protected ILoad2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ILOAD_2;
	}
}