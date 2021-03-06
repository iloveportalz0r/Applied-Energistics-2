package appeng.helpers;

import java.util.EnumSet;
import java.util.HashMap;

import appeng.api.config.SecurityPermissions;
import appeng.api.networking.security.ISecurityRegistry;

public class PlayerSecurityWrapper implements ISecurityRegistry
{

	final HashMap<Integer, EnumSet<SecurityPermissions>> target;

	public PlayerSecurityWrapper(HashMap<Integer, EnumSet<SecurityPermissions>> playerPerms) {
		target = playerPerms;
	}

	@Override
	public void addPlayer(int PlayerID, EnumSet<SecurityPermissions> permissions)
	{
		target.put( PlayerID, permissions );
	}
}
