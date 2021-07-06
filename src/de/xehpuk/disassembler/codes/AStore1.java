package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AStore1 extends AStoreAbstract {
	protected AStore1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ASTORE_1;
	}
}