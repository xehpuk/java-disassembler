package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AStore3 extends AStoreAbstract {
	protected AStore3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ASTORE_3;
	}
}