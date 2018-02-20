package org.repositoryminer.metrics.ast;

/**
 * This enum contains the node types.
 */
public enum NodeType {

	RETURN,
	IF,
	ELSE,
	SWITCH,
	SWITCH_CASE,
	SWITCH_DEFAULT,
	FOR,
	DO_WHILE,
	WHILE,
	BREAK,
	CONTINUE,
	TRY,
	CATCH,
	FINALLY,
	THROW,
	CONDITIONAL_EXPRESSION,
	EXPRESSION,
	METHOD_INVOCATION,
	FIELD_ACCESS,
	VARIABLE_DECLARATION,
	CLASS_DECLARATION,
	ENUM_DECLARATION,
	STRUCT,
	ANNOTATION_DECLARATION;
}