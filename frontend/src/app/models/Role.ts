export class Role {
  idRole: string;
  roleName: string;

  static cloneBase(role: Role):Role{
    const cloneRole: Role = new Role();
    cloneRole.idRole = role.idRole;
    cloneRole.roleName = role.roleName;
    return cloneRole;
  }
}
