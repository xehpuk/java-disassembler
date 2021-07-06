package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ILoad1 extends ILoadAbstract {
	protected ILoad1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ILOAD_1;
	}
}