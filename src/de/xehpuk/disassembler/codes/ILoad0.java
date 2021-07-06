package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ILoad0 extends ILoadAbstract {
	protected ILoad0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ILOAD_0;
	}
}