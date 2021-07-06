package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ILoad3 extends ILoadAbstract {
	protected ILoad3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ILOAD_3;
	}
}